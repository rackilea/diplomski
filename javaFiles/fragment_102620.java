package com.spring.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.course.domain.Request;
import com.spring.course.enums.RequestState;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long>{

    public List<Request> findAllByOwnerId(Long id);

    @Query("UPDATE request SET state = :state WHERE id = :id")
    public Request updateStatus(Long id, RequestState state);

}