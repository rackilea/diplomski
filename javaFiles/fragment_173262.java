apiVersion: extensions/v1beta1
kind: Deployment
metadata:
  name: my-database
  labels:
    app: my-database
spec:
  replicas: 1
  strategy:
    type: Recreate
  template:
    metadata:
      labels:
        app: my-database
    spec:
      containers:
      - image: postgres:9.6.3
        name: my-database
        ports:
        - containerPort: 5432
        resources: {}
        volumeMounts:
        - mountPath: "/var/lib/postgresql/data:Z"
          name: postgresdb-storage
      restartPolicy: Always
      volumes:
      - name: postgresdb-storage
        persistentVolumeClaim:
          claimName: postgresdb-volume-claim
status: {}