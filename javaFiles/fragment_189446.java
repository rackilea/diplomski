package com.custom.package;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.batch.core.JobInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CustomJobInstanceDao {

    public static final String BATCH_TABLE_PREFIX = "BATCH";

    private static final String GET_JOBS_WITH_STATUS_AFTER_DATE = "SELECT ji.JOB_INSTANCE_ID, ji.JOB_NAME FROM %PREFIX%_JOB_EXECUTION je LEFT JOIN %PREFIX%_JOB_INSTANCE ji "
            + " ON je.JOB_INSTANCE_ID = ji.JOB_INSTANCE_ID WHERE ji.JOB_NAME = ? AND je.STATUS = ? AND je.START_TIME > ? GROUP BY  je.JOB_INSTANCE_ID";

    private static final String GET_RUNNING_JOBS_AFTER_DATE = "SELECT ji.JOB_INSTANCE_ID, ji.JOB_NAME FROM %PREFIX%_JOB_EXECUTION je LEFT JOIN %PREFIX%_JOB_INSTANCE ji "
            + " ON je.JOB_INSTANCE_ID = ji.JOB_INSTANCE_ID WHERE ji.JOB_NAME = ? AND je.END_TIME is NULL AND je.START_TIME > ? GROUP BY  je.JOB_INSTANCE_ID";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<JobInstance> getJobInstancesWithStatusAfterStartDate(final String jobName, final String status,
            final DateTime afterStartTime) {

        return jdbcTemplate.query(getQuery(GET_JOBS_WITH_STATUS_AFTER_DATE), new Object[] {jobName, status,
                afterStartTime.toDate()}, new JobInstanceRowMapper());
    }

    public List<JobInstance> getRunningJobInstancesAfterStartDate(final String jobName, final DateTime afterStartTime) {

        return jdbcTemplate.query(getQuery(GET_RUNNING_JOBS_AFTER_DATE),
                new Object[] {jobName, afterStartTime.toDate()}, new JobInstanceRowMapper());
    }

    private String getQuery(final String base) {
        return StringUtils.replace(base, "%PREFIX%", BATCH_TABLE_PREFIX);
    }

    private final class JobInstanceRowMapper implements ParameterizedRowMapper<JobInstance> {

        public JobInstanceRowMapper() {
        }

        @Override
        public JobInstance mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final JobInstance jobInstance = new JobInstance(rs.getLong(1), rs.getString(2));
            // should always be at version=0 because they never get updated
            jobInstance.incrementVersion();
            return jobInstance;
        }
    }

}