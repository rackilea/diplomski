@Entity
public class FavoriteScreen {
   ... attributes...

   @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @JoinColumn(name = "screen_id")
   Screen screen
}