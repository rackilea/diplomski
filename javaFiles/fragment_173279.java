package com.couchbase.repository;

import java.util.List;
import org.springframework.data.couchbase.core.view.View;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.couchbase.client.protocol.views.Query;
import com.couchbase.entity.Data;

public interface DataRepository extends CrudRepository<Data, String> {

    @View(designDocument="Data",viewName="findByKey1AndKey2")
    public List<Data> findByKey1AndKey2(Query query);
}