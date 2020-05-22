import com.basho.riak.client.convert.KeyUtil.getKey;

object Main {

  def main(args: Array[String]): Unit = {
    val u = User("my_key")
    val k = getKey(u)
    System.out.println(k);

  }
}