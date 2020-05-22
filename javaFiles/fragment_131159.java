If currentSessions < MaxSessions {
   if !idleSessions.empty()
        use an idle session.
   else
        CreateNewSession.
} else {
   Block/Fail based on action chosen in : ActionOnExhaustion.
}