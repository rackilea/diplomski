public Jedis getDB() {
    jedis = pool.getResource();
    return jedis;
}

//cria um _id pra ser usado novamente quando for buscar os documentos
public void insert(Document d) {
    String key = "key" + i;
    String value = d.toString();
    Jedis jedis = this.getDB();
    jedis.set(key, value);
    jedis.close();
    i++;
}

//busca pelo _id
public void read() {
    Jedis jedis = this.getDB();
    Object doc = jedis.get("key" + i);
    jedis.close();
    i++;
    System.out.println(doc);
}