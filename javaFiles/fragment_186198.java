private MyEnum myEnum;
@Column(name="myenum") 
@Enumerated(EnumType.ORDINAL) 
public MyEnum getMyEnum() { 
    return myEnum 
}