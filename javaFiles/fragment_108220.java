{
   "kind": "Service",
   "apiVersion": "v1",
   "metadata": {
       "name": "myservice"
   },
   "spec": {
       "ports": [
           {
              "protocol": "TCP",
              "port": 80,
              "targetPort": 8080,
          }
      ],
      "selector": {
          "key": "value1",
      },¬
      "portalIP": "172.30.234.134",
      "type": "ClusterIP",
  }