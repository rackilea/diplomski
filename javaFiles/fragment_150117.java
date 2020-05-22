package com.avatar.dao;
import java.util.Date; 
import java.util.List; 
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 
import com.avatar.model.Student; 

@Repository 
public interface StudentDao extends JpaRepository<Student, String> { 
    List<Student> findByDateCurrent(Date dateCurrent); 
    List<> findDistinctByTechnoNomTechno(String nomTechno); 
}