// factory and an engine instance
VelocityEngineFactory velocityEngineFactory = new VelocityEngineFactory();
VelocityEngine engine = velocityEngineFactory.createVelocityEngine();
// now you need to give the variables you wanna have access from velocity script
VelocityContext context = new VelocityContext(properties);

ByteArrayOutputStream temp = new ByteArrayOutputStream();
BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(temp));
// generate the result, where scriptString is the velocity script
engine.evaluate(context, bufferedWriter, null, scriptString);
bufferedWriter.flush();
textResultant = temp.toString();