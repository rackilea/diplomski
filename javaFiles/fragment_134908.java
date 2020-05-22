js> defineClass("Member")
js> defineClass("Hosted")
js> var h = new Hosted();
js> var m = h.member;
js> m.toString();
called toString()
js> m instanceof Member;
true
js> m.__proto__;
[object Member]