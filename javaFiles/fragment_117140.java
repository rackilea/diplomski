@Component
class MyService(
  private val subs: List<Super<*>>
) {
  @Suppress("UNCHECKED_CAST")
  fun getSub(): List<Super<SomeType>>? = subs[0] as List<Super<SomeType>>
}