package com.example.libs

import java.util.Date
import java.text.SimpleDateFormat
import play.api.mvc.PathBindable
import scala.util.{Either, Failure, Success, Try}

object PathBinders {

    implicit def bindableDate(implicit stringBinder: PathBindable[String]) = new PathBindable[Date] {

        val sdf = new SimpleDateFormat("yyyy-MM-dd")

        override def bind(key: String, value: String): Either[String, Date] = {
            for {
                dateString <- stringBinder.bind(key, value).right
                date <- Try(sdf.parse(dateString)).toOption.toRight("Invalid date format.").right
            } yield date
        }

        override def unbind(key: String, date: Date): String = key + "=" + sdf.format(date)

    }

}