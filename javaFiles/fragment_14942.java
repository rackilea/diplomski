589:   public String(StringBuilder buffer)
 590:   {
 591:       this(buffer.value, 0, buffer.count);
 592:   }

 245:   public String(char[] data, int offset, int count)
 246:   {
 247:       this(data, offset, count, false);
 248:   }

 594:   /**
 595:    * Special constructor which can share an array when safe to do so.
 596:    *
 597:    * @param data the characters to copy
 598:    * @param offset the location to start from
 599:    * @param count the number of characters to use
 600:    * @param dont_copy true if the array is trusted, and need not be copied
 601:    * @throws NullPointerException if chars is null
 602:    * @throws StringIndexOutOfBoundsException if bounds check fails
 603:    */
 604:   String(char[] data, int offset, int count, boolean dont_copy)
 605:   {
 606:       if (offset < 0)
 607:           throw new StringIndexOutOfBoundsException("offset: " + offset);
 608:       if (count < 0)
 609:           throw new StringIndexOutOfBoundsException("count: " + count);
 610:       // equivalent to: offset + count < 0 || offset + count > data.length
 611:       if (data.length - offset < count)
 612:           throw new StringIndexOutOfBoundsException("offset + count: "
 613:                                                   + (offset + count));
 614:       if (dont_copy)
 615:       {
 616:           value = data;
 617:           this.offset = offset;
 618:       }
 619:       else
 620:       {
 621:           value = new char[count];
 622:           VMSystem.arraycopy(data, offset, value, 0, count);
 623:           this.offset = 0;
 624:       }
 625:       this.count = count;
 626:   }