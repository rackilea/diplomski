Path source=new Path("hdfs://HANameService/sources/hpm_support/apc_code/");
            Path target=new Path("hdfs://HANameService/staging/hpm_support/apc_code/");
            FileSystem fs = source.getFileSystem(conf);
            RemoteIterator<LocatedFileStatus> sourceFiles = fs.listFiles(source, true);
            if(sourceFiles != null) {
                while(sourceFiles.hasNext()){
                    FileUtil.copy(fs, sourceFiles.next().getPath(), fs, target, true, conf);
                }           
            }