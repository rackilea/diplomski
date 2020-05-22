rule "a or b"
when
    f: Fact( class == ChildAFact.class || == ChildBFact.class )
then
    System.out.println(f);
end