package controllers;

import javax.persistence.EntityManager;
import models.test.Foo;
import models.test.FooSystem;
import play.db.jpa.JPA;
import play.mvc.Controller;

public class TestController extends Controller
{
    public static void index() {
        EntityManager em = JPA.em();
        FooSystem fs = new FooSystem();
        Foo f1 = new Foo(fs);
        Foo f2 = new Foo(fs);
        f1.save();
        f2.save();
        fs.put(f1.getId(), f1);
        fs.put(f2.getId(), f2);
        fs.save();
        render();
    }
}