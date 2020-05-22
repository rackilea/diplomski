INSERT INTO "KPI_MEASURE" (
        id,
        created_at,
        kpi_project_id,
        kpi_frequency_id,
        kpi_metric_id,
        branch,
        value
    )
SELECT
    nextval('"KPI_MEASURE_ID_seq"'::regclass),
    ?,
    kpi_measure.kpi_project_id,
    kpi_measure.kpi_frequency_id,
    kpi_measure.kpi_metric_id ,
    kpi_measure.branch ,
    sum(kpi_measure.value)
FROM "KPI_MEASURE" kpi_measure
    INNER JOIN "KPI_METRIC" kpi_metric                      ON kpi_measure.kpi_metric_id = kpi_metric.id
    INNER JOIN "KPI_PROJECT" kpi_project                    ON kpi_measure.kpi_project_id = kpi_project.id
    INNER JOIN "KPI_AGGREGATION_PROJECT" kpi_agg_project    ON kpi_project.name = kpi_agg_project.child_project_name
    WHERE kpi_metric.aggregated = false
GROUP BY kpi_measure.branch, kpi_measure.kpi_metric_id, kpi_measure.kpi_project_id, kpi_project.name, kpi_measure.kpi_frequency_id;