import groovy.transform.Field

@Field int minValue   = 1;
@Field int maxValue   = 10;
@Field List listValues= [];
@Field Map enumMap    = [:];
@Field def rangeType  = "RANGE"; //RANGE,LIST,ENUM,NONE