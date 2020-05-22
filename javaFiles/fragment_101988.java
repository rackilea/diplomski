rule specialize_catch(b_try: block,
      E: qualifed_identifer, e: IDENTIFIER, b_recover: block,
      c_pre: catches, c_post: catches):
   statement -> statement
 " try { \b_try } 
   \c_pre
   catch ( \E \e ) { \b_recover }
   \c_post "
 -> 
  " try { \b_try }
    \c_pre 
    catch ( \least_specialized\(\E\,\b_try\,\c_pre\) \e ) { \b_recover }
    catch ( \E e ) { \b_recover }
    \c_post "
    if exists_specialized_exception(E,b_try,c_pre);