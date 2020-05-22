Message msg = new Message();
msg.setType("Hello");
//sessionObject = rbase.newStatefulSession();
FactHandle handle = sessionObject.insert(msg);
sessionobject.fireAllrules();
msg.setType("Hi");
sessionObject.update(handle, msg) // rules are re-evaluated here
session.fireAllRules(); // fire any pre-activated rule