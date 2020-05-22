public interface MyMapper {

    @Insert("INSERT INTO my_table (ip) VALUES (#{ip}::INET)")
    int insert(@Param("ip") String ip);

}