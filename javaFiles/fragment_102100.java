package com.gasx.corex.scheduler.rest;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gasx.corex.ext.scheduler.domain.SchedulerJob;
import com.gasx.corex.ext.user.domain.Profile;

public interface SchedulerJobRestRepositoryI extends JpaRepository<SchedulerJob, Integer> {
    List<SchedulerJob> findByName(@Param("name") String name);
}