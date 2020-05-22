import org.apache.commons.beanutils.BeanUtils


  implicit def any2WithProperties[T](o: T) = new AnyRef {
    def withProperties(props: Pair[String, Any]*) = {
      for ((key, value) <- props) { BeanUtils.setProperty(o, key, value) }
      o
    }
  }

  test("withProperties") {
    val l = new JLabel().withProperties("background" -> Color.RED, "text" -> "banana")
    l.getBackground should be (Color.RED)
    l.getText should be ("banana")
  }