val rootFontsDir = {
  val fontsDirPath = "/usr/share/fonts/truetype/" // Customise this
  val dir = new File(fontsDirPath)
  if (!dir.exists())
    throw new RuntimeException(s"Nothing found at path: '$fontsDirPath'")
  if (!dir.isDirectory)
    throw new RuntimeException(s"Object at path: '$fontsDirPath' isn't a directory")
  dir
}

def findFontFilesInDir(dir: File): Seq[File] = {
  val files = dir.listFiles()
  val subDirs = files.filter(_.isDirectory)
  val fontFiles = files.filter(_.isFile).filter(_.getName.endsWith(".ttf"))

  val subDirFontFiles = subDirs.flatMap(findFontFilesInDir)

  subDirFontFiles ++ fontFiles
}

case class FontInfo(font: Font, file: File)

val allFontInfo = findFontFilesInDir(rootFontsDir).map {
  case fontFile => FontInfo(Font.createFont(Font.TRUETYPE_FONT, fontFile), fontFile)
}