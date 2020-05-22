logger.info("Moving ORC files from HDFS to S3 !!")

    import scala.sys.process._

    logger.info("stopping spark context..##")
    val spark = IngestionContext.sparkSession
    spark.stop()
    logger.info("spark context stopped..##")
    logger.info("sleeping for 10 secs")
    Thread.sleep(10000) // this sleep is not required, this was just for debugging purpose, you can remove this in your final code.
    logger.info("woke up after sleeping for 10 secs")

    try {
      /**
       * following is the java version, off course you need take care of few imports
       */
      //val pb = new java.lang.ProcessBuilder("s3-dist-cp", "--src", INGESTED_ORC_DIR, "--dest", "s3:/" + paramMap(Storage_Output_Path).substring(4) + "_temp", "--srcPattern", ".*\\.orc")
      //val pb = new java.lang.ProcessBuilder("hadoop", "jar", "/usr/share/aws/emr/s3-dist-cp/lib/s3-dist-cp.jar", "--src", INGESTED_ORC_DIR, "--dest", "s3:/" + paramMap(Storage_Output_Path).substring(4) + "_temp", "--srcPattern", ".*\\.orc")
      //pb.directory(new File("/tmp"))
      //pb.inheritIO()
      //pb.redirectErrorStream(true)
      //val process = pb.start()
      //val is = process.getInputStream()
      //val isr = new InputStreamReader(is)
      //val br = new BufferedReader(isr)
      //var line = ""
      //logger.info("printling lines:")
      //while (line != null) {
      //  line = br.readLine()
      //  logger.info("line=[{}]", line)
      //}

      //logger.info("process goes into waiting state")
      //logger.info("Waited for: " + process.waitFor())
      //logger.info("Program terminated!")

      /**
       * following is the scala version
       */
      val S3_DIST_CP = "s3-dist-cp"
      val INGESTED_ORC_DIR = S3Util.getSaveOrcPath()

      // listing out all the files
      //val s3DistCpCmd = S3_DIST_CP + " --src " + INGESTED_ORC_DIR + " --dest " + paramMap(Storage_Output_Path).substring(4) + "_temp --srcPattern .*\\.orc"
      //-Dmapred.child.java.opts=-Xmx1024m -Dmapreduce.job.reduces=2
      val cmd = S3_DIST_CP + " --src " + INGESTED_ORC_DIR + " --dest " + "s3:/" + paramMap(Storage_Output_Path).substring(4) + "_temp --srcPattern .*\\.orc"

      //val cmd = "hdfs dfs -cp -f " + INGESTED_ORC_DIR + "/* " + "s3:/" + paramMap(Storage_Output_Path).substring(4) + "_temp/"
      //val cmd = "hadoop distcp " + INGESTED_ORC_DIR + "/ s3:/" + paramMap(Storage_Output_Path).substring(4) + "_temp_2/"

      logger.info("full hdfs to s3 command : [{}]", cmd)

      // command execution
      val exitCode = (stringToProcess(cmd)).!

      logger.info("s3_dist_cp command exit code: {} and s3 copy got " + (if (exitCode == 0) "SUCCEEDED" else "FAILED"), exitCode)
    } catch {
      case ex: Exception =>
        logger.error(
          "there was an exception while copying orc file to s3 bucket. {} {}",
          "", ex.getMessage, ex)
        throw new IngestionException("s3 dist cp command failure", null, Some(StatusEnum.S3_DIST_CP_CMD_FAILED))
    }