val vector = intArrayOf(
        R.mipmap.ic_launcher,
        R.mipmap.ic_launcher_round
)

for (c in 0 until grid.childCount) {

    grid.getChildAt(c).backgroundResource = vector[Random.nextInt(vector.size)]

}