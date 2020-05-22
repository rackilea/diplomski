void executeOnMembers(Runnable command, Collection<Member> members);
void executeOnMembers(Runnable command, MemberSelector memberSelector);
void executeOnAllMembers(Runnable command);

<T> Map<Member, Future<T>> submitToMembers(Callable<T> task, Collection<Member> members);
<T> Map<Member, Future<T>> submitToMembers(Callable<T> task, MemberSelector memberSelector);
<T> Map<Member, Future<T>> submitToAllMembers(Callable<T> task);