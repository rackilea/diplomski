private void register(ChannelHandlerContext ctx, Chat.User u){
                ctx.channel().attr(Main.KeyUser).set(u);
                ConversationUserMember member =                          ConversationPool.getOrCacheConversationUserMember(u);
                ConversationPool.UpdateConversations(member);
                Main.loggedUsers.add(ctx.channel());
                member.newChannel(ctx.channel());
                returnConversations(member,ctx); //this function is the one getting cut by netty.
            //    fireNewUser(u);
    }