package com.myBatis.Dao;


import org.apache.ibatis.session.SqlSession;

import com.myBatis.api.Village;
import com.myBatis.service.MyBatisUtil;


public class VillageDAO {

    public void save(Village village) {

        SqlSession session  = MyBatisUtil.getSqlSessionFactory().openSession();
        session.insert("com.myBatis.mapper.VillageMapper.insertVillage", village);
        session.commit();
        session.close();
    }

    public void update(Village village) {

        SqlSession session  = MyBatisUtil.getSqlSessionFactory().openSession();
        session.update("com.myBatis.mapper.VillageMapper.updateVillage", village);
        session.commit();
        session.close();
    }

    public void delete(Integer id) {

        SqlSession session  = MyBatisUtil.getSqlSessionFactory().openSession();
        session.delete("com.myBatis.mapper.VillageMapper.deleteVillage", id);
        session.commit();
        session.close();
    }

    public Village getData(Integer id) {

        SqlSession session  = MyBatisUtil.getSqlSessionFactory().openSession();
        Village village     = session.selectOne("com.myBatis.mapper.VillageMapper.selectVillage", id);
        session.close();
        return village;
    }
}