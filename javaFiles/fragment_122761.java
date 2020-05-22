implicit val decodeUserLevel: Decoder[UserLevel] = (c: HCursor) => for
{
    current_exp <- c.downField("current_exp").as[Int]
    current_level <- c.downField("current_level").as[Int]
    current_min <- c.downField("current_min").as[Int]
    next_exp <- c.downField("next_exp").withFocus(_.mapString
    {
        case """-""" => "-1"
        case default => default
    }).as[Int]
} yield
{
    UserLevel(current_exp, current_level, current_min, next_exp)
}