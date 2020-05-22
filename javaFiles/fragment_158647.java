public class Board extends BaseEntity implements Serializable {
  ..
  @OneToMany(mappedby="board")
  List<Card_Board> card_board_list;
  @Transient
  List<Card> cards;

  public List<Card> getCards(){
    if (cards ==null) {
      cards=new ArrayList();
      for (Card_Board cb: card_board_list) {
        cards.add(cb.getCard());
      }
    }
    return cards;
  }