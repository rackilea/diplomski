import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import com.avaje.ebean.*;



@Entity
@Table(name = "user_master")
public class UserMaster extends Model {

   @Id
   @Column(name = "user_id")
   private String userId;

   @Column(name = "user_name")
   private String userName;


   @Column(name = "password")
   private String password;

   @CreatedTimestamp
   @Column(name = "regist_time")
   private Timestamp registTime;


   @UpdatedTimestamp
   @Column(name = "update_time")
   private Timestamp updateTime;

/**
 * find
 */

  public static Find<Long,UserMaster> find = new Find<Long,UserMaster>(){};


}