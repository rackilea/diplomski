package com.example.libs

import java.util.Date
import play.api.mvc.PathBindable
import scala.util.Either

object PathBinders {

    implicit def bindableDate(implicit longBinder: PathBindable[Long]) = new PathBindable[Date] {

        override def bind(key: String, value: String): Either[String, Date] = {
            longBinder.bind(key, value).right.map(new Date(_))
        }

        override def unbind(key: String, date: Date): String = key + "=" + date.getTime().toString

    }

}