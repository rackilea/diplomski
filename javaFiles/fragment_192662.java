object MyImplicits {

    object ImplicitJson1{
        implicit val write:Write[Location] = "write to json all fields"
    }

    object ImplicitJson2{
        implicit val write:Write[Location] = "skip field a"
    }
}

object MyBusinessCode{

    def f1(location:Location){
        import MyImplicits.ImplicitJson1._
        Json.toJson(location)
    }
    def f2(location:Location){
        import MyImplicits.ImplicitJson2._
        Json.toJson(location)
    }

    def dynamicChoice(location:Location){
        implicit val write = {
            if(location.isEurope)           
                MyImplicits.ImplicitJson1.write
            else
                MyImplicits.ImplicitJson2.write
        }
        Json.toJson(location)
    }

}