create table SensorByDate
(
    sensor_id uuid,
    start_date datetime,
    end_date datetime,
    measurement int
    primary key (sensor_id, start_date)
)
with clustering order by (start_time DESC);