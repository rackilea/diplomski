.progress-bar > .bar
{
    -fx-background-insets: 3 3 3 3;
                            /* ^ was 4 */
}
.progress-bar > .track
{
    -fx-background-insets: 0, 0 0 1 0, 1 1 1 1;
                                        /* ^ was 2 */
}