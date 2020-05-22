Function<Tuple2<String, DeviceData>, DeviceData> mapDeviceData =
    new Function<Tuple2<String, DeviceData>, DeviceData>() {
      public DeviceData call(Tuple2<String, DeviceData> tuple) {
        return tuple._2();
      }
    };

Dataset<DeviceData> ddDS = ds.map(mapDeviceData) //extracts DeviceData from each record