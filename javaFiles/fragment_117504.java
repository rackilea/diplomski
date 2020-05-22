TypeResolver typeResolver = new TypeResolver();
MemberResolver memberResolver = new MemberResolver(

ResolvedType type = typeResolver.resolve(delegateType);
ResolvedTypeWithMembers members = memberResolver.resolve(type, null, null);
ResolvedMethod[] methods = members.getMemberMethods();