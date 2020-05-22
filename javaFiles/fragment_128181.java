@Entity
@Table(name="employee")
class Employee{

  @Id
  @GeneratedValue
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "job_name")
  private Job job;

 // other column and getter and setter
}

@Entity
@Table(name="job")
class Job{

      @Id
      @GeneratedValue
      private Integer id;

      @Column(name="job_name")
      private String jobName;

      //provide other column and getter setter

}