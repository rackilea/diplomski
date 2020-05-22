@Entity
public class Smartlist {

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        @Column(name = "smartlistId")
        private Integer smartlistId;

        @OneToOne( mappedBy = "smartlist", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
        private AccountEmailing accountEmailing;

        String name;

    public Integer getSmartlistId() {
        return smartlistId;
    }

    public void setSmartlistId(Integer smartlistId) {
        this.smartlistId = smartlistId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAccountEmail(AccountEmailing emailing)
    {
        accountEmailing=emailing;
        accountEmailing.setSmartlist(this);
    }


}



@Entity
@Table(name = "account_emailing")
public class AccountEmailing implements Serializable {

    @Id
    @Column(name="smartlistId")
    Integer id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "smartlistId")
    private Smartlist smartlist;

    String name;

    public Smartlist getSmartlist() {
        return smartlist;
    }

    public void setSmartlist(Smartlist smartlist) {
        this.smartlist = smartlist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}