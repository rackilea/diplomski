val ipData = sc.wholeTextFiles("abc.log")
val ipSingleLog = ipData.flatMap(x=>x._2.split("!")).filter(x=>x.trim.startsWith("device"))
val logData = ipSingleLog.map(x=>{
  val rowData = x.split("\n")
  var device = ""
  var description = ""
  var ipAddress = ""
  var status = ""
  for (data <- rowData){
    if(data.trim().startsWith("device")){
      device = data.split("device")(1)
    }else if(data.trim().startsWith("description")){
      description = data.split("description")(1)
    }else if(data.trim().startsWith("ip address")){
      ipAddress = data.split("ip address")(1)
    }else if(data.trim().startsWith("status")){
      status = data.split("status")(1)
    }
  }
  (device,description,ipAddress,status)
})
logData.foreach(println)