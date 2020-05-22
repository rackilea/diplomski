spark_task = BashOperator(
    task_id='spark_java',
    bash_command='spark-submit --class {{ params.class }} {{ params.jar }}',
    params={'class': 'MainClassName', 'jar': '/path/to/your.jar'},
    dag=dag
)