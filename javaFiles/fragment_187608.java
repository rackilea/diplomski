TypeResolver typeResolver = new TypeResolver();
MemberResolver memberResolver = new MemberResolver(typeResolver);

ResolvedType resolvedType = typeResolver.resolve(TestGenericsSub.class);
ResolvedTypeWithMembers resolvedTypeWithMembers = memberResolver.resolve(resolvedType, null, null);
ResolvedMethod resolvedGetMethod = resolvedTypeWithMembers.getMemberMethods()[0];

System.out.println(resolvedGetMethod.getReturnType()); // TestGenericsImpl