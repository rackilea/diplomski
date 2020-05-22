apiVersion: v1
kind: PersistentVolumeClaim
metadata:
  name: postgresdb-volume-claim
spec:
  storageClassName: postgresdb-class
  accessModes:
  - ReadWriteMany
  resources:
    requests:
      storage: 100Gi
status: {}