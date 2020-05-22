ConstantExpression exp = new ConstantExpression(" ");
exp.setTrim(false);

from("timer:test?fixedRate=true&period=5000")
.setBody(exp)
.log("'${body}'");