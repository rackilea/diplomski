public static Integer mySocketTimeout;

@Value("${api.values.socket-timeout}")
public void setSocketTimeout(Integer socketTime){
   mySocketTimeout = socketTime;
}