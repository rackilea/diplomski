package com.noahwm.hkapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.noahwm.hkapp.api.db.dao.AppUserDao;
import com.noahwm.hkapp.api.db.model.AppUser;
import com.noahwm.hkapp.api.service.AppUserService;

@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
public class AppUserServiceTestNGTest extends AbstractTransactionalTestNGSpringContextTests {

  @Autowired
  private AppUserService appUserService;

  @Test
  @Rollback
  @Transactional
  public void testApp() {
    AppUser appUser = new AppUser();
    appUser.setAge(10);
    appUser.setGender("F");
    appUser.setMobilePhone("13219201034");
    appUser.setName("HKAPP Test");
    appUserService.createUser(appUser);
    String appUserId = appUser.getId();
    Assert.assertNotNull(appUserId);
  }
}