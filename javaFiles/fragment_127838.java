//Set up pojo and make it into json string:
SomeClass pojo =new SomeClass();
pojo.setX("this is X");
JSONObject jsonObject = new Gson().toJson(pojo);
String jsonStr=jsonObject.toJSONString();
//Modify response and write json string
httpServletResponse.setStatus(200);//We are ok
httpServletResponse.setContentType("application/json");
httpServletResponse.setCharacterEncoding("UTF-8");
Writer writer = httpServletResponse.getWriter();
writer.write(jsonStr);
writer.close();
//Thats it