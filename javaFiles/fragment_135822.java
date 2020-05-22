String value1=rs.getString("value1");

bean = new Bean();                
bean.setvalue2(rs.getString("value2"));
bean.setvalue3(rs.getString("value3"));

beanList = holder.containsKey(value1) ? holder.get(value1) : new ArrayList<Bean>();
beanList.add(bean);
holder.put(value1, beanList);