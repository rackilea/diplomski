@Parsed
@Replace(expression = "`", replacement = "")
public String fieldA;

@Parsed(field = "BB")
@Replace(expression = "`", replacement = "")
public String fieldB;

@Parsed(index = 4)
@Replace(expression = "`", replacement = "")
public String fieldC;