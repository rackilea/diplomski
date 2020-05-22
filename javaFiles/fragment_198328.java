class Team implements Iterable<Member>
{
    public Iterator<Member> iterator() { ... }
}

for(Member member : team) ...