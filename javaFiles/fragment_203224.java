apiVersion: v1
kind: ConfigMap
metatada:
  name: app-config
data:
  application.conf: |
    play.cache.redis {
      # enable cluster mode
      source: cluster
      # nodes are defined as a sequence of objects:
      cluster:  [
        {
          # required string, defining a host the node is running on
          host:        localhost
          # required integer, defining a port the node is running on
          port:        6379
          # optional string, defines a password to use
          password:    null
        }
      ]
    }